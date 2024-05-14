import unittest
from unittest.mock import patch
from run import listar_articulos

class TestListarArticulos(unittest.TestCase):

    @patch('builtins.print')
    @patch('time.sleep', return_value=None)
    def test_listar_articulos_print(self, mock_sleep, mock_print):
        articulos = ["Articulo1", "Articulo2"]
        expected_output = ["Articulo1", "Articulo2"]
        self.assertEqual(listar_articulos(articulos), expected_output)
        #mock_print.assert_called_with("Articulos\n")
        #mock_print.assert_called_with("> Articulo1")
        #mock_print.assert_called_with("> Articulo2")
        mock_print.assert_called_with('Articulo1, Articulo2')

    @patch('builtins.print')
    @patch('time.sleep', return_value=None)
    def test_listar_articulos_return(self, mock_sleep, mock_print):
        articulos = ["Articulo1", "Articulo2"]
        expected_output = ["Articulo1", "Articulo2"]
        self.assertEqual(listar_articulos(articulos), expected_output)

if __name__ == '__main__':
    unittest.main()