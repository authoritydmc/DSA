class ProductOfNumbers {

    List<Integer> proArray;
    
    public ProductOfNumbers() {
        proArray=new ArrayList<>();
        proArray.add(1);
    }
    
    public void add(int num) {
        if(num==0)
        {
            proArray.clear();
            proArray.add(1);
        }else
        {
            proArray.add(proArray.get(proArray.size()-1)*num);
        }
    }
    
    public int getProduct(int k) {
        if(k>=proArray.size())return 0;
        return proArray.get(proArray.size()-1)/proArray.get(proArray.size()-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */