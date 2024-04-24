# Tiempo de envio: 16:48 a 16:59 -> 11 min
# Tiempo de envio: 18:20 a 19:31 -> 71 min
# Tiempo de envio: 20:05 a 20:30 -> 25 min

import smtplib

host        = "smtp-mail.outlook.com"
port        = 587
from_email  = "fakeflix_no-reply@outlook.com"
to_email    = "ericproves@gmail.com"
password    = "Fake_Flix_2023"
nombre      = "Eric"
codigo      = 256446
message = f""" Subject: Fake Flix reset password
Hola {nombre},

Este correo es debido a que has solicitado un reset del password.

Utiliza este codigo para cambiar el password satisfactoriamente:

    * {codigo}

Gracias,
El equipo FakeFlix
"""

smtp = smtplib.SMTP(host, port)

status_code, response = smtp.ehlo()
print(f"Echoing the server: {status_code} {response}")

status_code, response = smtp.starttls()
print(f"Starting TLS connection: {status_code} {response}")

status_code, response = smtp.login(from_email, password)
print(f"Logging in: {status_code} {response}")

smtp.sendmail(from_email, to_email, message)
smtp.quit()











"""from email.message import EmailMessage
import smtplib

remitente = "fakeflix_no-reply@outlook.com"
destinatario = "ericproves@gmail.com"
mensaje = "¡Hola, mundo!"
email = EmailMessage()
email["From"] = remitente
email["To"] = destinatario
email["Subject"] = "Correo de prueba"
email.set_content(mensaje)
smtp = smtplib.SMTP("smtp-mail.outlook.com", port=587)
smtp.starttls()
smtp.login(remitente, "Fake_Flix_2023")
smtp.sendmail(remitente, destinatario, email.as_string())
smtp.quit()"""



"""
content="Hello World"
mail=smtplib.SMTP('smtp.gmail.com', 587)
mail.ehlo()
mail.starttls()
sender='fakeflix2023@gmail.com'
recipient='ericproves@gmail.com'
mail.login('fakeflix2023@gmail.com','Fake_Flix_2023')
header='To:' + recipient + '\n'+'From:' + sender + '\n'+'subject:testmail\n'
content=header+content
mail.sendmail(sender, recipient, content)
mail.close()"""