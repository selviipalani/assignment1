public interface List <E> {
   //List interface with basic functions

   public E get(int pos);

   public boolean add(E item);

   public void add(int pos, E item);

   public E remove(int pos);

   public int size();

   public String toString();
}
