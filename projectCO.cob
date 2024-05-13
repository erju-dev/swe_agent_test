            IDENTIFICATION DIVISION.
            PROGRAM-ID. CONDITIONALS.

            DATA DIVISION.
              WORKING-STORAGE SECTION.
              *> setting up places to store values
              *> no values set yet
              01 NUM1 PIC 9(9).
              01 NUM2 PIC 9(9).
              01 NUM3 PIC 9(5).
              01 NUM4 PIX 9(6).
              *> create a positive and a negative
              *> number to check
              01 NEG-NUM PIC S9(9) VALUE -1234.
              *> create variables for testing classes
              01 CLASS1 PIC X(9) VALUE 'ABCD '.
              *> create statements that can be fed
              *> into a cobol conditional
              01 CHECK-VAL PIC 9(3).
                88 PASS VALUES ARE 041 THRUG 100.
                88 FAIL VALUES ARE 000 THRUG 40.
