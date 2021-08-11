package zero.to.mastery.data_structures.stacks.using_linked_list;

import java.util.EmptyStackException;

public class LinkedListStack {
  private StackNode top;
  private StackNode bottom;
  private int length;

  public LinkedListStack() {
    top = null;
    bottom = null;
    length = 0;
  }

  public int peak() {
    if(length == 0) {
      throw new EmptyStackException();
    }
    return top.getValue();
  }

  public int pop() {
    if(length == 0) {
      throw new EmptyStackException();
    }
    StackNode tempTop = top;
    top = top.getNext();
    length--;
    if(length == 0) {
      bottom = null;
    }
    return tempTop.getValue();
  }

  public void push(int valueToPush) {
    top = new StackNode(valueToPush, top);
    if(length == 0) {
      bottom = top;
    }
    length++;
  }

  public void printStack() {
    if(top == null) {
      return;
    }
    StackNode currentNode = top;
    System.out.print(currentNode.getValue());
    currentNode = currentNode.getNext();
    while (currentNode != null) {
      System.out.print("-->" + currentNode.getValue());
      currentNode = currentNode.getNext();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    LinkedListStack stack = new LinkedListStack();
    stack.push(5);
    stack.printStack();
    stack.push(3);
    stack.printStack();
    stack.pop();
    stack.pop();
    stack.printStack();
  }
}
