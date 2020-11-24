package pl.kskowronski.data;

import com.vaadin.flow.component.html.Image;

public enum MyIcons {

     ICON_APPLE("images/tenders/apple32.png", ""),
     ICON_BROOM("images/tenders/broom32.png", ""),
     ICON_TRANSPORT("images/tenders/transport32.png", ""),
     ICON_STERILIZATION("images/tenders/sterilization32.png", "");


    private String url;
    private String alt;

    MyIcons(String url, String alt) {
        this.url = url;
        this.alt = alt;
    }



    public Image create() {
        Image image = new Image(url, alt);
        image.getStyle().set("vertical-align", "middle"); // otherwise the icon will be just on the top left corner in the button
        return image;
    }

    /**
     * marign right distance if using Icon in Button with Text. so there is space between the icon and the button text
     * @param margin_right
     * @return
     */
    public Image create(int margin_right) {
        Image image = create();
        image.getStyle().set("margin-right", margin_right+"px"); //some space between icon and button text
        return image;
    }

}
