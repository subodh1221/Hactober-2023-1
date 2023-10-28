class Solution {
    boolean isSafe(int i,int j,int n,char [][] chessboard)
    {
        int tempI=i;
        int tempJ=j;
        
        while( tempI >= 0)
        {
            if(chessboard[tempI][j]=='Q')
                return false;
            tempI--;
        }
        
        tempI=i;
        tempJ=j;
        
        while( tempI >=0 && tempJ <= n-1)
        {
            if(chessboard[tempI][tempJ]=='Q')
                return false;
            
            tempI--;
            tempJ++;
        }
        
        tempI=i;
        tempJ=j;
        
        while( tempI >= 0 && tempJ >=0)
        {
            if(chessboard[tempI][tempJ]=='Q')
                return false;
            tempI--;
            tempJ--;
        }
        return true;
    }
    
    void help(int i,int n,char[][] chessboard,List<List<String>>ans)
    {
        if(i==n)
        {
            List<String>temp=new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                String currRow="";
                for(int k=0;k<n;k++)
                {
                    currRow=currRow+chessboard[j][k];
                }
                temp.add(currRow);
            }
            ans.add(new ArrayList(temp));
            return;
        }
        
        for(int j=0;j<n;j++)
        {
            if(isSafe(i,j,n,chessboard))
            {
                chessboard[i][j]='Q';
                
                help(i+1,n,chessboard,ans);
                
                chessboard[i][j]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String >>ans=new ArrayList<>();
        
        
        char[][] chessboard= new char[n][n];
        
        for(char[] arr: chessboard)
            Arrays.fill(arr,'.');
        
        help(0,n,chessboard,ans);
        return ans;
    }
}
