class Solution {
    public int numUniqueEmails(String[] emails) {
        

    return (int) Arrays.stream(emails).map(e->{
        String [] splt=e.split("@");
        e=splt[0];
        e=e.replace(".","");
        e=e.split("\\+")[0];
        return e+"@"+splt[1];
       }).distinct().count();
    }
}