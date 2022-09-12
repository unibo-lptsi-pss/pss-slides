class UsePoint3D{   

    public static void main(String[] args) {
        Point3D p = new Point3D();
        p.build(10.0, 20.0, 30.0);
        Point3D q = new Point3D();
        q.build(10.0, 20.0, 31.0);
        System.out.println("p's squared norm: " + p.getNormSquared());
        System.out.println("Are p and q the same point? " + p.equal(q));
    }
}
