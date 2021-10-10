#Tetris by Bell

'''

Challenge: Find the Tetris stone! by Honfu

Fill a 2-dimensional array with randomized letters.

Now write a function that scans the array for the shape of a specific Tetris stone. Output the coordinates of the stone(s).

Obviously all points that belong to the shape need to be there, and there must not be additional ones (diagonals don't matter).

Example for bolt shape:

aaaaa   valid: bolt shape of b's

abbaa 

aabba

aaaaa

aaaaa   invalid: one point missing

abbaa

aabaa

aaaaa

aaaaa   invalid: one point too many

abbba

abbaa

aaaaa

aaaaa   valid: diagonally adjacent point

abbab              doesn't matter

aabba

aaaaa

Choose a Tetris shape of your liking - or go crazy and do it for all the seven shapes.

Ideally, write a few test cases, and arrange it all so that everytime we run the code we'll get a new randomized array.

Have fun! :-)

'''

# Create a function that can apply formatting to lists of any length:

def ListToFormattedString(alist):

    # Create a format spec for each item in the input `alist`.

    # E.g., each item will be right-adjusted, field width=3.

    format_list = ['{:>2}' for item in alist] 

    # Now join the format specs into a single string:

    # E.g., '{:>3}, {:>3}, {:>3}' if the input list has 3 items.

    s = ' '.join(format_list)

    # Now unpack the input list `alist` into the format string.

    return s.format(*alist)

    

# score pieces using list comprehension

def findT(alist):

    score=0

    blist=[0,2,0,0,0,0,2,2,2]

    clist=[2,2,2,0,0,0,0,2,0]

    lofl=[blist,clist]

#    for item in alist for li in lofl:

    for idx, it in enumerate(alist[0:48]):

        value=sum ([a*b for a, b in zip(alist[idx:48], blist)])

#        print(value)

        if(score<value):

            score=value

            best=idx        

    if(score==16):print("T FOUND! AT ", best)

    return score

    

#7- The tetrominos in the list of sets extracted are shifted to the origin and the average of the 4 positions in the linear array gives a unique signature telling me the shape and orientation: for instance, the vertical I is 9  (0+6+12+18)/4, the horizontal 1.5 (0+1+2+3)/4

def findTetro(nums):

    t={150:"I leaning",225:"L right-rotated",250:"T",275:"J left-rotated",300:'S',350:'O square',375:"L left-rotated",400:'Z',450:'T upside-down',475:"J upside-down",533:"J right-rotated",538:"L upside-down",577:"L upside-down",550:'Z standing',570:"J right-rotated",575:"T right-rotated",578:"no idea",625:"T left-rotated",650:'S standing',725:'J',775:'L',900:'I'}

#    nums=tetra

# using list comprehension to add K to each element

    k=nums[0]

    avg = int(25*sum([x - k for x in nums]))

    if(avg==525):avg=avg+nums[-1]

    print("The fingerprint",avg,"indicates",t.get(avg,'...I have never seen this shape'))

    

# Use sets to find connected patches, clear pentominos, pairs, trios..

        

#***********************************main starts            

import random

import textwrap

print("Find and identify tetrominos in a random pattern!")

print()

#1-make the random array (1D, 54) and print it (2D, 6x9) b and . used for clarity. ann, bnn are work lists (54)

items = 40*['.']+14*['b']

ann=[]

bnn=[]

graph= {k: [] for k in range(54)}

random.shuffle(items)

# function to print lists of 54 elements as 6x9

print("\n".join(textwrap.wrap(ListToFormattedString(items),19,subsequent_indent=' ')))

print()

#2-annotate the array (b as 1) horizontally contiguous b as 2

#save connections in a dictionary (graph)

for idx, it in enumerate(items[0:54]):

    ann.append(1 if (it=='b') else 0)

    if (it=='b' and (((idx+1)%6!=0 and it==items[idx+1]) or (idx>0 and it==items[idx-1]and(idx)%6!=0))):

#        if((idx%6)==0):continue

        ann.pop()

        ann.append(2)

        if(idx==53):continue

        graph[idx].append(idx+1 if (it==items[idx+1]and(idx+1)%6!=0) else idx-1)

print("\n".join(textwrap.wrap(ListToFormattedString(ann),19,subsequent_indent=' ')))

print()

#3-annotate the array vertically

#save connections in a dictionary (graph)

for idx, it in enumerate(ann[0:48]):

    bnn.append(it)

#    print("out of range ",it,idx,idx-6,idx+6)

    if (it>0 and ((0<ann[idx+6]) or (idx>5 and 0<ann[idx-6]) )):

        bnn.pop()

        bnn.append(2)

        graph[idx].append(idx+6 if (0<ann[idx+6]) else idx-6)

for idx, it in enumerate(ann[48:54]):

    bnn.append(2 if(bnn[idx+48-6]==2 and it==1)else it)        

print("\n".join(textwrap.wrap(ListToFormattedString(bnn),19,subsequent_indent=' ')))

#4- use dictionary to find connected patches

print('\nNumber of connected fields: ',bnn.count(2))

print('\nRaw Dictionary, it can be queried as graph: ')

print("\n",graph)

# Filter dictionary, keeping elements whose values are not empty, adding keys in new dictionary newgraph (i would like to manipulate graph rather than copy into a new structure)

newgraph= {key: value for (key, value) in graph.items() if len(value) != 0 } 

print('\nFiltered Dictionary: ')

print("\n",newgraph)

trim=list()

print("\nAdding key to values: ")

for idx in list(newgraph):

    newgraph[idx].append(idx)

print(newgraph)

newlist= list(newgraph.values())

print('\nList: ')

print(newlist)

while(len(newlist)>0):

    a=set(newlist[0])

    for  item in newlist:    

        if(a&set(item)):

         a=(a|set(item))

    for  item in reversed(newlist):    

        if(a&set(item)):

         a=(a|set(item))

    if(len(a)>=4):

        print(a," Found a patch!")

        if(a not in trim and not (any([ a.issubset(i) for i in trim]))):trim.append(a)

    del newlist[0]

print("\nRecovered values: ", trim)

tetro=list()

[tetro.append(i) for i in trim if len(i)==4]

if(tetro==[]):

    print("The pattern contains no tetrominos")

else:

    print(" After filtering large patches ",tetro)

#Reannotate original array

ann *= 0 # fastest

bnn *= 0

for it in range(54):

    ann.append('X' if (any([ it in i for i in tetro])) else 0)

for it in range(54):

    bnn.append(2 if (any([ it in i for i in tetro])) else 0)    

print("\n".join(textwrap.wrap(ListToFormattedString(ann),19,subsequent_indent=' ')))

# Use stats to identify shape, pass a sorted list rather than a set to use min/max

for i in tetro:

    ann=sorted(i)

    findTetro(ann)

#print("\n",findT(bnn))

