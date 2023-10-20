public class NestedIterator implements Iterator<Integer> {
    private final List<NestedInteger> list;
    private int i = 0;
    
    private NestedIterator currIter;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = nestedList;
    }

    @Override
    public Integer next() {
        var currInt = list.get(i);
        if (currInt.isInteger()) {
            i++;
            return currInt.getInteger();
        } else {
            Integer res = currIter.next();
            if (!currIter.hasNext()) {
                currIter = null;
                i++;
            }
            
            return res;
        }
    }

    @Override
    public boolean hasNext() {
        if (i >= list.size()) {
            return false;
        }
        
        var currInt = list.get(i);
        if (currInt.isInteger()) {
            return true;
        }
        
        if (currIter == null) {
            currIter = new NestedIterator(currInt.getList());
        }
        if (currIter.hasNext()) {
            return true;
        }
        currIter = null;
        i++;
        
        return hasNext();
    }
}