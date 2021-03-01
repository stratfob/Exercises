import java.util.LinkedList;

public class LC10_Regex {

    //Queue
    public static boolean isMatch(String s, String p){
        LinkedList<Character> q = new LinkedList<Character>();
        char preceedingCharacter = p.charAt(0);
        int i;
        for (i = 0; i < s.length(); i++) {
            q.add(s.charAt(i));
        }
        for (i = 0; !q.isEmpty(); i++) {
            if(i >= p.length()){
                return false;
            }
            char c = q.peekFirst();
            switch (p.charAt(i)){
                case '.':
                    q.poll();
                    preceedingCharacter = '.';
                    break;
                case '*':
                    if(c==preceedingCharacter || preceedingCharacter == '.'){
                        q.poll();
                        i--;
                    }
                    break;
                default:
                    if (c == p.charAt(i)){
                        q.poll();
                        preceedingCharacter = p.charAt(i);
                    }
                    else{
                        if(i < p.length()-1){
                            if (p.charAt(i+1) != '*'){
                                if(!(i > 1 && p.charAt(i-1) == '*' && p.charAt(i) == preceedingCharacter)){
                                    return false;
                                }
                            }
                            else{
                                preceedingCharacter = p.charAt(i);
                            }
                        }
                        else return false;
                    }
            }
        }
        if(i < p.length()){
            if(i == p.length()-1){
                return p.charAt(i) == '*';
            }
            if(p.charAt(i) == '*') i++;
            while (i < p.length()){
                if(p.charAt(i) != '*'){
                    if(i == p.length()-1) return false;
                    if(p.charAt(i+1) != '*'){
                        return false;
                    }
                }
                
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("abbc", "ab*bc"));
        System.out.println(isMatch("ab", ".*c"));
        System.out.println(isMatch("aaa", "a*a"));

    }
}
