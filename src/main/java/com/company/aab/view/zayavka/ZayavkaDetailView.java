package com.company.aab.view.zayavka;

import com.company.aab.entity.Avtomobil;
import com.company.aab.entity.Zayavka;
import com.company.aab.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.kit.action.BaseAction;
import io.jmix.flowui.model.DataContext;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.model.InstanceLoader;
import io.jmix.flowui.view.*;

@Route(value = "zayavkas/:id", layout = MainView.class)
@ViewController("Zayavka.detail")
@ViewDescriptor("zayavka-detail-view.xml")
@EditedEntityContainer("zayavkaDc")
public class ZayavkaDetailView extends StandardDetailView<Zayavka> {
    @ViewComponent
    private DataContext dataContext;
    @ViewComponent
    private InstanceContainer<Zayavka> zayavkaDc;
    @ViewComponent
    private InstanceLoader<Zayavka> zayavkaDl;

    @Subscribe("avomobiliDataGrid.createAvto")
    public void onAvomobiliDataGridCreate(final ActionPerformedEvent event) {
        if(zayavkaDc.getItem()==null) {
            zayavkaDc.setItem(dataContext.create(Zayavka.class));
            zayavkaDc.getItem().setNomer("dsdsd");
        }
        Avtomobil a = dataContext.create(Avtomobil.class);
        a.setMarka("ds");
        a.setZayavka(zayavkaDc.getItem());
        zayavkaDc.getItem().getAvomobili().add(a);
        zayavkaDl.load();
    }

}