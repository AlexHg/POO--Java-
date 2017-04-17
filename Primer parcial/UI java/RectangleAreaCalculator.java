import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public  class RectangleAreaCalculator extends JFrame{
    private JLabel lengthLabel, widthLabel, areaLabel, perimetroLabel;
    private JTextField lengthText, widthText, areaText, perimetroText;
    //Ancho y Alto
    private static final int HEIGHT = 400;
	private static final int WIDTH = 600;
    //Botones
    private JButton calculateButton, exitButton;
    //Eventos de botones
    private CalculateButtonHandler calculateButtonHandler;
    private ExitButtonHandler exitButtonHandler;

	public RectangleAreaCalculator(){

		lengthLabel = new JLabel("Ingresa la altura del rectangulo: ");
        widthLabel = new JLabel("Ingresa el ancho del rectangulo:" );
        areaLabel = new JLabel("El area es: ", SwingConstants.RIGHT);
        perimetroLabel = new JLabel("El perimetro es:", SwingConstants.RIGHT);

        lengthText = new JTextField(10);
        widthText = new JTextField(10);
        areaText = new JTextField(10);
        perimetroText = new JTextField(10);
	
    //Esta sección específica los controladores para los botones y añade un ActionListener.

        calculateButton = new JButton("Calcular");
        calculateButtonHandler = new CalculateButtonHandler();
        calculateButton.addActionListener(calculateButtonHandler);

        exitButton = new JButton("Cerrar");
        exitButtonHandler = new ExitButtonHandler();
        exitButton.addActionListener(exitButtonHandler);

        setTitle("Area y Perimetro de un Rectangulo");

        Container pane = getContentPane(); //Obtiene el lienzo
        pane.setLayout(new GridLayout(7, 2)); //Establece el Layout con el que se creara el programa

    // El diseño de Grid requiere que agregue componentes al panel de contenido, en el orden en que deben aparecer

        pane.add(new JLabel("AREA Y PERIMETRO DE UN RECTANGULO"));
        pane.add(new JLabel(" "));

        pane.add(lengthLabel);
        pane.add(lengthText);

        pane.add(widthLabel);
        pane.add(widthText);

        pane.add(areaLabel);
        pane.add(areaText);

        pane.add(perimetroLabel);
        pane.add(perimetroText);

        pane.add(new JLabel(" "));
        pane.add(new JLabel(" "));

        pane.add(calculateButton); //Onclick
        pane.add(exitButton);

        setSize(WIDTH,HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

	private class CalculateButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double width, length, area, perimetro;
          	
            length = Double.parseDouble(lengthText.getText());                                  
	        width = Double.parseDouble(widthText.getText());

            area = length * width;
            areaText.setText("" + area);

            perimetro = width*2 + length*2;
            perimetroText.setText("" + perimetro);
        }
    }

	public class ExitButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
	}
   
    public static void main(String[] args){
	    new RectangleAreaCalculator();
	}
}
