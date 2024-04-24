# Fichero de configuracion para la DB
# (Seguridad, funcionalidades...)

# Importamos modulos
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker, declarative_base

# (1) Creamos el engine, el cual permite a SQLAlchemy
#     comunicarse con la DB en un dialecto concreto
engine = create_engine("sqlite:///database/fakeflix.db",
                       connect_args={"check_same_thread": False}) # Para que flask pueda
                                                            # trabajar en varios hilos

# (2) Creamos sesion (para realizar transacciones en la DB)
#     (Session en mayus porque crea una clase)
#     Luego creamos un objeto "session" de esa clase
Session = sessionmaker(bind=engine)
session = Session()

# (3) Ahora vamos al fichero models.py en los modelos (clases)
#     donde queremos que se transformen en tablas, le añadiremos
#     esta variable y esto se encargara de mapear y vincular cada
#     clase a cada tabla
Base = declarative_base()



