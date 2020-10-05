package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller
{
    private Figure figure;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ImageView figureImage;

    @FXML
    private Button triangleButton;

    @FXML
    private Button circleButton;

    @FXML
    private Button RhombusButton;

    @FXML
    private Button QuadrateButton;

    @FXML
    private Button rectangleButton;

    @FXML
    private Label side1OrRadiusLabel;

    @FXML
    private Label side2Label;

    @FXML
    private Label side3Label;

    @FXML
    private Label side4Label;

    @FXML
    private Label figureNameLabel;

    @FXML
    private TextField side1OrRadiusTextBox;

    @FXML
    private TextField side2TextBox;

    @FXML
    private TextField side3TextBox;

    @FXML
    private TextField side4TextBox;

    @FXML
    private Label errorLabel;

    @FXML
    private Label perimeterLabel;

    @FXML
    private Label squareLabel;

    @FXML
    private Button startButton;

    @FXML
    public void initialize()
    {


        triangleButton.setOnAction( actionEvent ->
        {
            initializeTriangle();
            figure = new Triangle( 0, 0, 0 );
        } );
        circleButton.setOnAction( actionEvent ->
        {
            initializeCircle();
            figure = new Сircle1(0 );
        } );
        RhombusButton.setOnAction( actionEvent ->
        {
            initializeRhombus();
            figure = new Rhombus( 0 );
        } );
        QuadrateButton.setOnAction( actionEvent ->
        {
            initializeQuadrat();
            figure = new Quadrate( 0 );
        } );
        rectangleButton.setOnAction( actionEvent ->
        {
            initializeRectangle();
            figure = new Rectangle( 0, 0 );
        } );

        startButton.setOnAction( actionEvent ->
        {
                if( figureNameLabel.getText().equals( "Triangle" ) )
                {
                    goWithTriangle((Triangle) figure);
                }
                else if( figureNameLabel.getText().equals( "Circle" ) )
                {
                    goWithCircle((Сircle1) figure);
                }
                else if( figureNameLabel.getText().equals( "Rectangle" ) )
                {
                    goWithRectangle((Rectangle) figure);
                }
                else if( figureNameLabel.getText().equals( "Quadrate" ) )
                {
                    goWithQuadrate((Quadrate) figure);
                }
                else
                {
                    goWithRhombus((Rhombus) figure);
                }

        });
    }

    private void goWithTriangle(Triangle figure)
    {
        if( !side1OrRadiusTextBox.getText().equals( "" ) )
        {
            figure.setASide( Double.parseDouble( side1OrRadiusTextBox.getText() ) );
        }
        if( !side2TextBox.getText().equals( "" ) )
        {
            figure.setBSide( Double.parseDouble( side2TextBox.getText() ) );
        }
        if( !side3TextBox.getText().equals( "" ) )
        {
            figure.setCSide( Double.parseDouble( side3TextBox.getText() ) );
        }
        reactOnValue();
        if( tryIfNormalTriangle() && tryIfNormalSide( side1OrRadiusTextBox ) && tryIfNormalSide( side2TextBox ) && tryIfNormalSide( side3TextBox ) )
        {
            perimeterLabel.setText( Double.toString( figure.perimeter ) );
            squareLabel.setText( Double.toString( figure.square ) );
        }
    }

    private void goWithCircle(Сircle1 figure)
    {
        if( !side1OrRadiusTextBox.getText().equals( "" ) )
        {
            figure.setR( Double.parseDouble( side1OrRadiusTextBox.getText() ) );
        }
        reactOnValue();
        if( tryIfNormalSide( side1OrRadiusTextBox ))
        {
            perimeterLabel.setText( Double.toString( figure.perimeter ) );
            squareLabel.setText( Double.toString( figure.square ) );
        }
    }
    private void goWithRectangle(Rectangle figure)
    {
        if( !side1OrRadiusTextBox.getText().equals( "" ) )
        {
            figure.setSide1( Double.parseDouble( side1OrRadiusTextBox.getText() ) );
        }
        if( !side2TextBox.getText().equals( "" ) )
        {
            figure.setSide2( Double.parseDouble( side2TextBox.getText() ) );
        }
        reactOnValue();
        if( tryIfNormalSide( side1OrRadiusTextBox ) && tryIfNormalSide( side2TextBox ) )
        {
            perimeterLabel.setText( Double.toString( figure.perimeter ) );
            squareLabel.setText( Double.toString( figure.square ) );
        }
    }
    private void goWithQuadrate(Quadrate figure)
    {
        if( !side1OrRadiusTextBox.getText().equals( "" ) )
        {
            figure.setSide( Double.parseDouble( side1OrRadiusTextBox.getText() ) );
        }
        reactOnValue();
        if( tryIfNormalSide( side1OrRadiusTextBox ) )
        {
            perimeterLabel.setText( Double.toString( figure.perimeter ) );
            squareLabel.setText( Double.toString( figure.square ) );
        }
    }
    private void goWithRhombus(Rhombus figure)
    {
        if( !side1OrRadiusTextBox.getText().equals( "" ) )
        {
            figure.setSide( Double.parseDouble( side1OrRadiusTextBox.getText() ) );
        }
        reactOnValue();
        if( tryIfNormalSide( side1OrRadiusTextBox ) )
        {
            perimeterLabel.setText( Double.toString( figure.perimeter ) );
            squareLabel.setText( Double.toString( figure.square ) );
        }
    }
    private void initializeTriangle()
    {
        mainPane.setStyle("-fx-background-color: #900000;");
        figureImage.setImage(new Image("triangle.gif"));
        figureNameLabel.setText( "Triangle" );
        side1OrRadiusLabel.setText( "AB = " );
        side2Label.setText( "BC = " );
        side3Label.setText( "CB = " );
        side4Label.setText("");
        side1OrRadiusTextBox.setOpacity(1);
        side2TextBox.setOpacity(1);
        side3TextBox.setOpacity(1);
        side4TextBox.setOpacity(0);
    }

    private void initializeCircle()
    {
        mainPane.setStyle("-fx-background-color: #ff9900;");
        figureImage.setImage(new Image("circle.jpg"));
        figureNameLabel.setText( "Circle" );
        side1OrRadiusLabel.setText( "R = " );
        side2Label.setText( "" );
        side3Label.setText( "" );
        side4Label.setText( "" );
        side1OrRadiusTextBox.setOpacity(1);
        side2TextBox.setOpacity(0);
        side3TextBox.setOpacity(0);
        side4TextBox.setOpacity(0);
    }

    private void initializeRhombus()
    {
        mainPane.setStyle( "-fx-background-color: #339900;" );
        figureImage.setImage(new Image("rhombus.png"));
        figureNameLabel.setText( "Rhombus" );
        side1OrRadiusLabel.setText( "AB = " );
        side2Label.setText( "" );
        side3Label.setText( "" );
        side4Label.setText( "" );
        side1OrRadiusTextBox.setOpacity(1);
        side2TextBox.setOpacity(0);
        side3TextBox.setOpacity(0);
        side4TextBox.setOpacity(0);
    }

    private void initializeQuadrat()
    {
        mainPane.setStyle( "-fx-background-color: #006699;" );
        figureImage.setImage(new Image("quadrat.jpg"));
        figureNameLabel.setText( "Quadrate" );
        side1OrRadiusLabel.setText( "AB = " );
        side2Label.setText( "" );
        side3Label.setText( "" );
        side4Label.setText( "" );
        side1OrRadiusTextBox.setOpacity(1);
        side2TextBox.setOpacity(0);
        side3TextBox.setOpacity(0);
        side4TextBox.setOpacity(0);
    }

    private void initializeRectangle()
    {
        mainPane.setStyle( "-fx-background-color: #663399;" );
        figureImage.setImage(new Image("rectangle.jpg"));
        figureNameLabel.setText( "Rectangle" );
        side1OrRadiusLabel.setText( "AB = " );
        side2Label.setText( "BC = " );
        side3Label.setText( "" );
        side4Label.setText( "" );
        side1OrRadiusTextBox.setOpacity(1);
        side2TextBox.setOpacity(1);
        side3TextBox.setOpacity(0);
        side4TextBox.setOpacity(0);
    }
    private void reactOnValue()
    {
        if( !tryIfNormalSide( side1OrRadiusTextBox ) )
        {
            side1OrRadiusTextBox.setStyle( "-fx-background-color: #ff0000;" );
        }
        else
            side1OrRadiusTextBox.setStyle( "-fx-background-color: #ffffff;" );
        if( !tryIfNormalSide(side2TextBox) )
        {
            side2TextBox.setStyle( "-fx-background-color: #ff0000;" );
        }
        else
            side2TextBox.setStyle( "-fx-background-color: #ffffff;" );
        if( !tryIfNormalSide(side3TextBox) )
        {
            side3TextBox.setStyle( "-fx-background-color: #ff0000;" );
        }
        else
            side3TextBox.setStyle( "-fx-background-color: #ffffff;" );

        if( !tryIfNormalTriangle() && figureNameLabel.getText().equals("Triangle"))
        {

            errorLabel.setText( "Error: It`s not a triangle" );
        }
        else
            errorLabel.setText( "" );
    }

    private boolean tryIfNormalSide( TextField side )
    {
        try
        {
            checkParameter( Double.parseDouble( side.getText() ) );
            return true;
        }
        catch ( IllegalArgumentException e )
        {
            return false;
        }

    }

    private boolean tryIfNormalTriangle()
    {
        try
        {
            checkTriangle(
                    Double.parseDouble( side1OrRadiusTextBox.getText() ),
                    Double.parseDouble( side2TextBox.getText() ),
                    Double.parseDouble( side3TextBox.getText() ) );
            return true;
        }
        catch ( IllegalArgumentException e )
        {
            return false;
        }

    }

    private void checkParameter( double side )
    {
        if( side <= 0 )
        {
            throw new IllegalArgumentException( "side <= 0" );
        }
    }

    private void checkTriangle( double aSide, double bSide, double cSide )
    {
        if( aSide >= bSide + cSide ||
                bSide >= aSide + cSide ||
                cSide >= aSide + bSide )
            throw new IllegalArgumentException( "It`s not a triangle" );
    }
}
