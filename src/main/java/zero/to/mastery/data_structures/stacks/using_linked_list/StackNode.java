package zero.to.mastery.data_structures.stacks.using_linked_list;

public class StackNode {

  private int value;
  private StackNode next;

  public StackNode(int value) {
    this.value = value;
    this.next = null;
  }

  public StackNode(int value, StackNode next) {
    this.value = value;
    this.next = next;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public StackNode getNext() {
    return next;
  }

  public void setNext(StackNode next) {
    this.next = next;
  }
}
