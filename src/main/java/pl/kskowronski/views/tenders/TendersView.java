package pl.kskowronski.views.tenders;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.kskowronski.data.entity.inap.TenderDTO;
import pl.kskowronski.data.service.inap.TenderService;
import pl.kskowronski.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

import java.util.List;
import java.util.Optional;

@Route(value = "hello", layout = MainView.class)
@PageTitle("Przetargi")
@CssImport("./styles/views/przetargi/przetargi-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class TendersView extends HorizontalLayout {


    private Grid<TenderDTO> gridTenders;
    private TenderService tenderService;

    public TendersView(@Autowired TenderService tenderService) {
        setHeight("85%");
        setId("tenders-view");
        this.tenderService = tenderService;

        this.gridTenders = new Grid<>(TenderDTO.class);
        gridTenders.setColumns("purchaser", "city", "deadlineApplication", "responsiblePersonFormal");
        gridTenders.setHeightFull();

        Optional<List<TenderDTO>> tenders = tenderService.getAllTendersBeforePlacing("5");
        if (tenders.get().size() > 0 ) {
            gridTenders.setItems(tenders.get());
        } else {
            Notification.show("Brak przetargów na 5 dni", 3000, Notification.Position.MIDDLE);
        }


        add(gridTenders);

    }

}
