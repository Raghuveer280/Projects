import currency_converter as c
import tkinter as tk
from PIL import ImageTk,Image
win=tk.Tk()
win.geometry("1500x1500")
win.title("Currency Converter")

img=Image.open('my_photo.jpeg')
new=img.resize((1500,1500))
bg=ImageTk.PhotoImage(new)

img_l=tk.Label(win,image=bg)
img_l.grid(row=0,column=0)

options=["INR","USD","GBP","EUR","JPY","CAD","RUB"]
default="Choose Any Currency"
v1=tk.StringVar(win)
v2=tk.StringVar(win)
v1.set(default)
v2.set(default)

a=c.CurrencyConverter()

def clicked():
    amt=float(e1.get())
    cur1=v1.get()
    cur2=v2.get()
    data=a.convert(amt,cur1,cur2)
    l5=tk.Label(win,text="Converted Amount:",font="Times 25 bold",bg="yellow").place(x=350,y=575)
    l6=tk.Label(win,text=data,font="Times 25 bold",bg="yellow").place(x=350,y=625)

def clear_ent():
    e1.delete(0,'end')
    v1.set(default)
    v2.set(default)

l1=tk.Label(win,text="Currency Converter",font="Times 48 bold",bg='AntiqueWhite3').place(x=400,y=200)

l2=tk.Label(win,text="Enter the Amount:",font="Times 25 bold",bg="salmon").place(x=350,y=300)
e1=tk.Entry(win,font="Times 25 bold",width=20)

l3=tk.Label(win,text="From Currency:",font="Times 25 bold",bg="salmon").place(x=350,y=350)
#e2=tk.(win,font="Times 25 bold")
e2=tk.OptionMenu(win, v1, *options)
e2.config(font="Times 25 bold",width=18)

l4=tk.Label(win,text="To Currency :",font="Times 25 bold",bg="salmon").place(x=350,y=400)
#e3=tk.Entry(win,font="Times 25 bold")
e3=tk.OptionMenu(win, v2, *options)
e3.config(font="Times 25 bold",width=18)

b=tk.Button(win,text="EXIT",font="Times 25 bold",bg="light blue",activebackground="grey",width="5",command=win.destroy).place(x=950,y=500)
c=tk.Button(win,text="CLEAR",font="Times 25 bold",bg="#856ff8",activebackground="orange",width="6",command=clear_ent).place(x=800,y=500)
r=tk.Button(win,text="CONVERT",font="Times 25 bold",bg="navajo white",activebackground="light green",width="10",command=clicked).place(x=500,y=500)

e1.place(x=650,y=305)
e2.place(x=650,y=355)
e3.place(x=650,y=405)

win.mainloop()
