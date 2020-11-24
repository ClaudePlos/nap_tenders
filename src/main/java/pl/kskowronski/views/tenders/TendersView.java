package pl.kskowronski.views.tenders;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import pl.kskowronski.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "hello", layout = MainView.class)
@PageTitle("Przetargi")
@CssImport("./styles/views/przetargi/przetargi-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class TendersView extends HorizontalLayout {


    public TendersView() {
        setId("tenders-view");






    }

}
