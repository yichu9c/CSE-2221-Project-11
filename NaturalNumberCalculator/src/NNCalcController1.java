import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Controller class.
 *
 * @author Put your name here
 */
public final class NNCalcController1 implements NNCalcController {

    /**
     * Model object.
     */
    private final NNCalcModel model;

    /**
     * View object.
     */
    private final NNCalcView view;

    /**
     * Useful constants.
     */
    private static final NaturalNumber TWO = new NaturalNumber2(2);
    private static final NaturalNumber ONE = new NaturalNumber2(1);
    private static final NaturalNumber INT_LIMIT = new NaturalNumber2(
            Integer.MAX_VALUE);

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(NNCalcModel model,
            NNCalcView view) {

        view.updateTopDisplay(model.top());
        view.updateBottomDisplay(model.bottom());

        if (!model.bottom().isZero()) {
            view.updateDivideAllowed(true);
        } else {
            view.updateDivideAllowed(false);
        }

        if (!model.bottom().equals(ONE)) {
            view.updatePowerAllowed(true);
        } else {
            view.updatePowerAllowed(false);
        }

        if (model.bottom().compareTo(model.top()) <= 0) {
            view.updateSubtractAllowed(true);
        } else {
            view.updateSubtractAllowed(false);
        }

        if (model.bottom().compareTo(INT_LIMIT) < 0) {
            view.updatePowerAllowed(true);
        } else {
            view.updatePowerAllowed(false);
        }

        if (model.bottom().compareTo(INT_LIMIT) < 0
                && model.bottom().compareTo(TWO) >= 0) {
            view.updateRootAllowed(true);
        } else {
            view.updateRootAllowed(false);
        }

    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public NNCalcController1(NNCalcModel model, NNCalcView view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSwapEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {

        this.model.top().copyFrom(this.model.bottom());
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processAddEvent() {

        this.model.bottom().add(this.model.top());
        this.model.top().clear();
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSubtractEvent() {

        this.model.top().subtract(this.model.bottom());
        this.model.bottom().transferFrom(this.model.top());
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processMultiplyEvent() {

        this.model.bottom().multiply(this.model.top());

        this.model.top().clear();
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processDivideEvent() {

        NaturalNumber remainder = this.model.top().divide(this.model.bottom());
        this.model.bottom().transferFrom(this.model.top());
        this.model.top().transferFrom(remainder);
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processPowerEvent() {
        /*
         * Should be legal because updateViewToMatchModel checks to see if the
         * bottom is less than the max int value.
         */
        this.model.top().power(this.model.bottom().toInt());
        this.model.bottom().transferFrom(this.model.top());
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processRootEvent() {

        this.model.top().root(this.model.bottom().toInt());
        this.model.bottom().transferFrom(this.model.top());
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processAddNewDigitEvent(int digit) {
        this.model.bottom().multiplyBy10(digit);
        updateViewToMatchModel(this.model, this.view);

    }

}
