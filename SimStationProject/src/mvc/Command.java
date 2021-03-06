/*
 *  04/07: Trung Le: First initialize
 */
package mvc;

public abstract class Command {
    protected Model model;

    public Command(Model model)
    {
        super();
        this.model = model;
    }

    public abstract void execute();
}
