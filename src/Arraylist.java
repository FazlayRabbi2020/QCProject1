public class Arraylist{
  // Implementation of this structure is to store all Member Objects

  static final int DEFAULT_SIZE = 100;
  int currMaxSize; //current max number of elements this can hold
  int nElem;      //number of elements this is currently holding
  private Member[] array;

  //constructors//
  public Arraylist() {
    nElem = 0;
    currMaxSize = DEFAULT_SIZE;
    array = new Member[currMaxSize];
  }

  public Arraylist(int specifiedSize) {
    nElem = 0;
    currMaxSize = specifiedSize;
    array = new Member[currMaxSize];
  }

  ////methods////
  public int size() {
    return nElem;
  }

  public boolean isFull(){
    return nElem == currMaxSize;
  }

  public boolean isEmpty() {
    return nElem == 0;
  }

  public boolean indexIsValid(int i){
    return (i >= 0 && i < nElem); //check if an index is valid
  }
    
  public int set(int i, Member m) {
    if(indexIsValid(i)){
      array[i] = m;
      return 0; //succeed
    }else{
      return -1; //failed
    }
      
  }

  public Member get(int i) {
    return (indexIsValid(i))?array[i]:null; //return Member object if index is valid, else return null
  }

  ///add command  
  public int add(Member m) {
    int successCode = 0; //0 for default success, 1 for logging size has changed
    if(isFull()){
      extendsArray();
      successCode = 1;
    }
    array[nElem++] = m;
    return successCode;
  }
    
  ///remove command 
  public Member remove (int index) {
    if(indexIsValid(index)){
      Member temp = array[index]; //element to be removed

      //replace the removed element by shifting the array
      for(int i = index; i < nElem-1; i++){
        array[i] = array[i+1];
      }

      nElem--;
      return temp;
    }else{
      return null; //failed
    }
  }

  ///modify command
  public void modify(){

  }

  public void extendsArray(){
    currMaxSize += DEFAULT_SIZE; //update size
    Member[] newArray = new Member[currMaxSize];

    //copy elements to the new array
    for(int i = 0; i < nElem; i++){
      newArray[i] = array[i];
    }

    array = newArray;
  }

  public void printAll() {
    System.out.println("CUNYID\tName");
    for (int i = 0; i < nElem; i++) {
      System.out.println(array[i].getCUNYid()+"\t"+array[i].getName());
    }
  }

}
