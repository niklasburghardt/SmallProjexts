import requests
from bs4 import BeautifulSoup
import smtplib

mail = input("Empfänger: ")
wish = float(input("Preiswunsch: "))
URL = input("URL: ")
title = ""

headers = {"User-Agent": 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36'}



def checkPrice():
    global title
    page = requests.get(URL, headers=headers)

    soup = BeautifulSoup(page.content, 'html.parser')

    price = soup.find(id="priceblock_ourprice").get_text()
    title = soup.find(id="productTitle").get_text()
    converted_price = float(price[0:3])

    print(converted_price)

    if(converted_price < wish):
        sendEmail()


def sendEmail():
    server = smtplib.SMTP('smtp.gmail.com', 587)
    server.ehlo()
    server.starttls()
    server.ehlo()
    server.login('ndburghardt@gmail.com', 'oanoxzdwgpftkqil')

    subject = f'Price of {title.strip()} fell down!'
    body = "Check the link --> "+URL

    msg = f"Subject: {subject} \n\n{body}"

    server.sendmail(
        'ndburghardt@gmail.com',
        mail,
        msg
    )

    server.quit()

checkPrice()
