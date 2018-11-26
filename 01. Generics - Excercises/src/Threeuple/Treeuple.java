package Threeuple;

public class Treeuple<K> extends Tuple {

  private K thirdElemeent;

     private K thirdElement;
   public Treeuple(Object firstElement, Object secondElement, K thirdElement) {
       super(firstElement, secondElement);
       this.thirdElement = thirdElement;
   }
   public K getThirdElement() {
       return thirdElement;
   }

   public void setThirdElement(K thirdElement) {
       this.thirdElement = thirdElement;
   }
   @Override
   public String toString() {
       return super.toString() + " -> " + this.thirdElement;
   }

}
