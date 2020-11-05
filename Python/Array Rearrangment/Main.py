def solve():
    n = int(input())
    
    a = []
    b = []
    for i in range(n):
        a.append(int(input()))
    for i in range(n):
        b.appand(int(input()))

    a.sort();
    b.sort();
    b.reverse();

    for i in range(n):
        if(a[i] +b[i] > x):
            print("NO")
            return

    print("YES")   

t = int(input())
while(t > 0):
    t -= 1
    solve()
