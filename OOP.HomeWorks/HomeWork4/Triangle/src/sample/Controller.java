package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import triangle.Triangle;
import javafx.scene.control.Button;

public class Controller
{

    @FXML
    private TextField cTextBox;

    @FXML
    private TextField aTextBox;

    @FXML
    private TextField bTextBox;

    @FXML
    private TextField alphaTextBox;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField betaTextBox;

    @FXML
    private TextField gamaTextBox;

    @FXML
    private Label squareLabel;

    @FXML
    private Label perimetrLabel;

    @FXML
    private Button startButton;

    @FXML
    public void initialize()
    {
        Triangle triangle;
            if( !aTextBox.getText().equals("") && !bTextBox.getText().equals("") && !cTextBox.getText().equals("") )
            {
                triangle = new Triangle( Double.parseDouble(aTextBox.getText() ),
                        Double.parseDouble( bTextBox.getText() ),
                        Double.parseDouble( cTextBox.getText() ) );
            }
            else
            {
                triangle = new Triangle( 0, 0, 0 );
            }

        startButton.setOnAction( actionEvent ->
        {
            if( !aTextBox.getText().equals( "" ) )
            {
                triangle.setASide( Double.parseDouble( aTextBox.getText() ) );
            }
            if( !bTextBox.getText().equals( "" ) )
            {
                triangle.setBSide( Double.parseDouble( bTextBox.getText() ) );
            }
            if( !cTextBox.getText().equals( "" ) )
            {
                triangle.setCSide( Double.parseDouble( cTextBox.getText() ) );
            }
            reactOnValue();
            if( tryIfNormalTriangle() && tryIfNormalSide( aTextBox ) && tryIfNormalSide( bTextBox ) && tryIfNormalSide( cTextBox ) )
            {
                perimetrLabel.setText( Double.toString( triangle.perimeter ) );
                squareLabel.setText( Double.toString( triangle.square ) );
                alphaTextBox.setText( Double.toString( triangle.getAlphaAngle() ) + "*" );
                betaTextBox.setText( Double.toString(triangle.getBetaAngle() )+ "*" );
                gamaTextBox.setText( Double.toString(triangle.getGammaAngle() )+ "*" );
            }
        });
    }
    private void reactOnValue()
    {
        if( !tryIfNormalSide( aTextBox ) )
        {
            aTextBox.setStyle( "-fx-background-color: #ff0000;" );
        }
        else
            aTextBox.setStyle( "-fx-background-color: #ffffff;" );
        if( !tryIfNormalSide(bTextBox) )
        {
            bTextBox.setStyle( "-fx-background-color: #ff0000;" );
        }
        else
            bTextBox.setStyle( "-fx-background-color: #ffffff;" );
        if( !tryIfNormalSide(cTextBox) )
        {
            cTextBox.setStyle( "-fx-background-color: #ff0000;" );
        }
        else
            cTextBox.setStyle( "-fx-background-color: #ffffff;" );

        if( !tryIfNormalTriangle() )
        {
            errorLabel.setText( "Error: It`s not a triangle" );
        }
        else
            errorLabel.setText( "" );
    }

    private boolean checkEquilateral()
    {
        return cTextBox.getText().equals(aTextBox.getText())
                && aTextBox.getText().equals(bTextBox.getText());
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
                    Double.parseDouble( aTextBox.getText() ),
                    Double.parseDouble( bTextBox.getText() ),
                    Double.parseDouble( cTextBox.getText() ) );
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

