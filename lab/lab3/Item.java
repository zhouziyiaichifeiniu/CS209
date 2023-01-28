package lab.lab3;


/**
 * An item with a description and a part number.
 */
public class Item implements Comparable<Item>
{
   private String description;
   private int partNumber;

   public Item(String aDescription, int aPartNumber)
   {
      description = aDescription;
      partNumber = aPartNumber;
   }

   public String getDescription() {
      return description;
   }

   public int getPartNumber() {
      return partNumber;
   }

   public String toString()
   {
      return "[no=" + partNumber + ", desc=" + description + "]";
   }

   @Override
   public int compareTo(Item o) {
      if (this.getPartNumber() == o.getPartNumber()) return this.getDescription().length() - o.getDescription().length();
      return this.getPartNumber() - o.getPartNumber();
   }

//   public int compareTo(Item other)
//   {
//      int diff = Integer.compare(partNumber, other.getPartNumber());
//      return diff != 0 ? diff : description.compareTo(other.getDescription());
//   }
}
