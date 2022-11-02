public class UseVector{
    public static void main(String[] s){
    	Vector<Object> vo = new Vector<>();
    	vo.addElement(1);
    	vo.addElement("2");
    	vo.addElement(new java.util.Date());
    	
    	Vector<Double> vd = new Vector<>();
    	vd.addElement(Math.random());
    	vd.addElement(Math.random());
    	
    	vo.addAll(vd);
    	System.out.println(vo);
    }
}
