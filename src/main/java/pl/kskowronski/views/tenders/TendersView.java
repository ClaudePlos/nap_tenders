package pl.kskowronski.views.tenders;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.provider.SortDirection;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.kskowronski.data.MyIcons;
import pl.kskowronski.data.entity.inap.TenderDTO;
import pl.kskowronski.data.service.inap.TenderService;
import pl.kskowronski.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Route(value = "hello", layout = MainView.class)
@PageTitle("Tenders")
@CssImport("./styles/views/przetargi/przetargi-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class TendersView extends HorizontalLayout {


    private Grid<TenderDTO> gridTenders;
    private TenderService tenderService;

    public TendersView(@Autowired TenderService tenderService) {
        setHeight("90%");
        setId("tenders-view");
        this.tenderService = tenderService;

        this.gridTenders = new Grid<>(TenderDTO.class);


        gridTenders.setColumns();

        gridTenders.addComponentColumn(item -> createIconTenderType(gridTenders, item)).setHeader("Type").setWidth("40px");
        gridTenders.addColumn("purchaser").setWidth("250px");
        gridTenders.addColumn("city");
        gridTenders.addColumn("deadlineApplication").setWidth("150px");
        gridTenders.addColumn("responsiblePersonFormal").setWidth("200px");
        gridTenders.addColumn("packageNumber").setWidth("30px");
        gridTenders.addColumn("priority").setWidth("30px");
        gridTenders.addColumn("participate").setWidth("30px");


        gridTenders.setHeightFull();

        Optional<List<TenderDTO>> tenders = tenderService.getAllTendersBeforePlacing("5");
        if (tenders.get().size() > 0 ) {
            List<TenderDTO> tendersDTO = tenders.get().stream().sorted(Comparator.comparing(TenderDTO::getDeadlineSort))
                    .collect(Collectors.toList());
            gridTenders.setItems(tendersDTO);
        } else {
            Notification.show("Brak przetargów na 5 dni", 3000, Notification.Position.MIDDLE);
        }


        add(gridTenders);

    }

    private Image createIconTenderType(Grid<TenderDTO> grid, TenderDTO item) {

        Image icon;
        if (item.getTenderType().equals("CATER")){
            icon = MyIcons.ICON_APPLE.create();
        } else if  (item.getTenderType().equals("UM")){
            icon = MyIcons.ICON_BROOM.create();
        } else if  (item.getTenderType().equals("TRANSPORT")){
            icon = MyIcons.ICON_TRANSPORT.create();
        } else {
            icon = MyIcons.ICON_STERILIZATION.create();
        }
        return icon;
    }

}
