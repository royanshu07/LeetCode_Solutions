class Pair{
    String word;
    int num;
    public Pair(String word,int num){
        this.num = num;
        this.word= word;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String i:wordList){
            map.put(i,1);
        }
    
    Queue<Pair> q = new LinkedList<>();
    Pair p = new Pair(beginWord,1);
    q.add(p);
    while(!q.isEmpty()){
        Pair temp = q.poll();
        for(int i = 0;i<temp.word.length();i++){
            for(char c ='a';c<='z';c++){
                String news = temp.word.substring(0,i)+c+temp.word.substring(i+1);
                if(map.containsKey(news)){
                    map.remove(news);
                    if(news.equals(endWord)){
                        return temp.num+1;
                    }
                    Pair newp = new Pair(news,temp.num+1);
                    q.add(newp);
                }
            }
        }
    }
        return 0;}
    
}