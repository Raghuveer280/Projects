import tkinter as tk

win=tk.Tk()
win.geometry("520x250")
win.title("CALCULATOR")

result=tk.StringVar()
def calculate():
   try:
      result.set(eval(e.get()))
   except:
      result.set("Error")

def clear():
   e.delete(0,'end')
   
def feed(value):
   result.set(e.get()+value)
   
e=tk.Entry(win,textvariable=result,width=30,font="Arial 25")
e.grid(row=0,column=0,columnspan=3)

b0=tk.Button(win,width=20,text="1",font="Calibri 12",fg="Red",bg="yellow",command=lambda:feed("1")).grid(row=1,column=0)
b1=tk.Button(win,width=20,text="2",font="Calibri 12",fg="Red",bg="yellow",command=lambda:feed("2")).grid(row=1,column=1)
b2=tk.Button(win,width=20,text="3",font="Calibri 12",fg="Red",bg="yellow",command=lambda:feed("3")).grid(row=1,column=2)
b3=tk.Button(win,width=20,text="4",font="Calibri 12",fg="Red",bg="yellow",command=lambda:feed("4")).grid(row=2,column=0)
b4=tk.Button(win,width=20,text="5",font="Calibri 12",fg="Red",bg="yellow",command=lambda:feed("5")).grid(row=2,column=1)
b5=tk.Button(win,width=20,text="6",font="Calibri 12",fg="Red",bg="yellow",command=lambda:feed("6")).grid(row=2,column=2)

b6=tk.Button(win,width=20,text="7",font="Calibri 12",fg="Red",bg="yellow",command=lambda:feed("7")).grid(row=3,column=0)
b7=tk.Button(win,width=20,text="8",font="Calibri 12",fg="Red",bg="yellow",command=lambda:feed("8")).grid(row=3,column=1)
b8=tk.Button(win,width=20,text="9",font="Calibri 12",fg="Red",bg="yellow",command=lambda:feed("9")).grid(row=3,column=2)

opr1=tk.Button(win,width=20,text="0",font="Calibri 12",fg="Red",bg="yellow",command=lambda:feed("0")).grid(row=4,column=1)
opr2=tk.Button(win,width=20,text="+",font="Calibri 12",fg="Red",bg="yellow",command=lambda:feed("+")).grid(row=5,column=0)
opr3=tk.Button(win,width=20,text="-",font="Calibri 12",fg="Red",bg="yellow",command=lambda:feed("-")).grid(row=5,column=1)
opr4=tk.Button(win,width=20,text="*",font="Calibri 12",fg="Red",bg="yellow",command=lambda:feed("*")).grid(row=5,column=2)
opr5=tk.Button(win,width=20,text="/",font="Calibri 12",fg="Red",bg="yellow",command=lambda:feed("/")).grid(row=6,column=1)

equal=tk.Button(win,width=20,text="=",font="Calibri 12",fg="green",bg="gold",command=calculate).grid(row=6,column=2)
C=tk.Button(win,width=20,text="Clear",font="Calibri 12",fg="green",bg="gold",command=clear).grid(row=6,column=0)

win.minsize(520,250)
win.mainloop()
