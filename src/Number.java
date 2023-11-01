public class Number {

    private int denary;
    private String hexadecimal;
    private String binary;

    public Number(int value){
        this.denary = value;
        setBinary();
        setHexadecimal();
    }

    public void negate(){
        denary *= -1;
        setBinary();
        setHexadecimal();
    }

    public void setDenary(int value){
        this.denary = value;
        setBinary();
        setHexadecimal();
    }

    public String getHexadecimal() {
        return hexadecimal;
    }

    public int getDenary(){
        return denary;
    }

    public String getSignedBinary() {
        return binary;
    }

    private void setBinary(){
        int temp = denary >0 ? denary : -denary;
        String binaryString = "";
        while(temp > 0){
            binaryString = (denary>0 ? temp % 2 : ((temp)%2+1)%2) + binaryString;
            temp /= 2;
        }
        if(denary<0){
            binaryString = binaryString.substring(0,binaryString.lastIndexOf('0')) + '1'
                    +"0".repeat(binaryString.length()-binaryString.lastIndexOf('0')-1);
        }
        while(!(binaryString.length() % 4==0 && Math.pow(2,binaryString.length()-1)>Math.abs(denary)) || binaryString.length() == 0){
            binaryString = (denary < 0 ? "1" : "0")+binaryString;
        }
        binary=binaryString;
    }

    private void setHexadecimal(){
        String hex="";
        String[] base16 = {"0","1","2","3","4","5","6","7","8","9","10","A","B","C","D","E","F"};
        for(int i=0;i<getSignedBinary().length();i+=4){
            String temp = getSignedBinary().substring(i,i+4);
            hex += base16[(int) ((temp.charAt(0)-'0')*Math.pow(2,3) + (temp.charAt(1)-'0')*Math.pow(2,2)
            + (temp.charAt(2)-'0')*Math.pow(2,1) + (temp.charAt(0)-'0')*Math.pow(2,0)) %16 ];
        }
        hexadecimal=hex;
    }

    @Override
    public String toString() {
        return "Number{" +
                "denary=" + denary +
                " binary=" + binary +
                " hexadecimal=" + hexadecimal +
                '}';
    }
}
