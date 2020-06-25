package code.assessments.may_2020;

import java.util.LinkedList;
import java.util.Objects;

public class StackOperation {

    // We will use 2 linked list here to maintain the transaction, once a transaction starts we will append the
    private LinkedList<LinkedList<Integer>> transactionalStack = new LinkedList<>();

    // To maintain the transaction count and nested transaction
    int transactionCount = 0;

    public StackOperation() {

    }

    public void push(int item) {
        if(transactionalStack.size() <= 0) {
            LinkedList<Integer> tempStack = new LinkedList<>();
            tempStack.push(item);
            transactionalStack.push(tempStack);
        } else {
            transactionalStack.peekFirst().push(item);
        }
    }

    public int top() {
        if(transactionalStack.size() <= 0) {
            return 0;
        } else {
            LinkedList<Integer> tempStack = transactionalStack.peekFirst();
            if(Objects.nonNull(tempStack))
                return tempStack.peekFirst();
            else
                return 0;
        }
    }

    public void pop() {
        LinkedList<Integer> tempStack = transactionalStack.peekFirst();
        if(Objects.nonNull(tempStack))
            tempStack.pop();
    }

    public void begin() {

        //Create new transactional stack list when starting the begin transaction
        transactionalStack.push(new LinkedList<>());
        transactionCount++;

    }

    public boolean rollback() {
        if (transactionCount > 0 && transactionalStack.size() > 0 ) {
            transactionalStack.pop();
            transactionCount--;
            return true;
        }
        return false;
    }

    public boolean commit() {
        //merge 2 stacks here
        if (transactionCount > 0 && transactionalStack.size() > 0 ) {
            LinkedList<Integer> commitStack = transactionalStack.pop();

            LinkedList<Integer> beforeCommitStack = transactionalStack.pop();

            commitStack.addAll(beforeCommitStack);
            transactionalStack.push(commitStack);

            transactionCount--;
            return true;
        }
            return false;
    }

    public static void main(String[] args) {
        StackOperation  operation = new StackOperation();
        System.out.println(operation.rollback());
        System.out.println(operation.commit());
        operation.pop();
        operation.top();
        operation.push(1);
        operation.push(2);
        System.out.println(operation.top());

        operation.begin();
        operation.push(3);
        operation.push(4);
        System.out.println(operation.top());
        operation.commit();
        System.out.println(operation.top());


        operation.begin();
        operation.push(5);
        operation.rollback();

        System.out.println(operation.top());




        StackOperation sol = new StackOperation();
        sol.push(4);
        sol.begin();                    // start transaction 1
        sol.push(7);                    // stack: [4,7]
        sol.begin();                    // start transaction 2
        sol.push(2);                    // stack: [4,7,2]
        System.out.println(sol.rollback());// == true;  // rollback transaction 2
        System.out.println(sol.top());// == 7;          // stack: [4,7]
        sol.begin();                    // start transaction 3
        sol.push(10);                   // stack: [4,7,10]
        System.out.println(sol.commit());// == true;    // transaction 3 is committed
        System.out.println(sol.top()); //== 10;
        System.out.println(sol.rollback());// == true;  // rollback transaction 1
        System.out.println(sol.top());// == 4;          // stack: [4]
        System.out.println(sol.commit());// == false;   // there is no open transaction

    }

}
