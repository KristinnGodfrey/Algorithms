 'board': board }

#init vars
currentY = 2
currentX = 0
points = 0
board = createBoard()
candies = [ (0,2), (1,1), (3,3), (4,2), (4,4), (4,5) ]

for candy in candies:
    setCandy(board,candy[0],candy[1])

result = moveAnt(board, points, currentY, currentX)

print(result['board'])
print("points:", result['points'])
```
output:
![](Screenshots/gAntOutput.png)
