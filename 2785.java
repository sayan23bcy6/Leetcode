class Solution {
    public String sortVowels(String s) {
        int n=s.length();
        char[] arr=new char[n];
        int k=0;
        char[] charay = s.toCharArray();
        for(int i=0;i<n;i++)
        {   char ch=charay[i];
            if(ch=='A' || ch=='a' || ch=='E' || ch=='e' || ch=='I' || ch=='i' || ch=='O' || ch=='o' || ch=='U' || ch=='u')
            {arr[k++]=ch;
            charay[i]='*';}
        }
        Arrays.sort(arr,0,k);
        k=0;
        for(int i=0;i<n;i++)
        {
            char ch=charay[i];
            if(ch=='*')
            charay[i]=arr[k++];
        }
        return new String(charay);

    }
}