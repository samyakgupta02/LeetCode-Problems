class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N<0){
            x = 1/x;
            N = -N;
        }

        double ans = 1.0;
        while(N>0){
            if((N %2)== 1){         //if N is odd ----> x.x^n-1
                ans = ans * x;     // if N is even ----> (x^2)^N/2.    this reduces the calculation ans hence the complexity. 
            }
            x = x*x;
            N = N/2;
        }
        return ans;
        }
        
    }
