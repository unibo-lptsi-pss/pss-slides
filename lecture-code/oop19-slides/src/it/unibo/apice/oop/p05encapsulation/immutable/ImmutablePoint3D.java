package it.unibo.apice.oop.p05encapsulation.immutable;

public class ImmutablePoint3D {

   private final double x; // x coordinate
   private final double y; // y coordinate
   private final double z; // z coordinate

   public ImmutablePoint3D(final double x, final double y, final double z) {
      this.x = x;
      this.y = y;
      this.z = z;
   }

   public double getSquareModule() {
      return this.x * this.x + this.y * this.y + this.z * this.z;
   }

   public double getX() {
      return this.x;
   }

   public double getY() {
      return this.y;
   }

   public double getZ() {
      return this.z;
   }

   /* A method that changes state is mimicked by creating a new object */
   public ImmutablePoint3D translate(final double x, final double y, final double z) {
      return new ImmutablePoint3D(this.x + x, this.y + y, this.z + z);
   }
}
