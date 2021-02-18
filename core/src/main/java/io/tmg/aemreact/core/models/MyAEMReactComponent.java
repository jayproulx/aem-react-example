package io.tmg.aemreact.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.jcr.resource.api.JcrResourceConstants;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.settings.SlingSettingsService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables=Resource.class, resourceType = "services101/components/content/myaemreactcomponent")
@Exporter( name = "jackson", extensions = "json" )
public class MyAEMReactComponent {

    @Inject
    private SlingSettingsService settings;

    @Self
    private Resource resource;

    @Inject @Named(JcrResourceConstants.SLING_RESOURCE_TYPE_PROPERTY) @Default(values="No resourceType")
    protected String resourceType;

    private String message;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String description;

    @PostConstruct
    protected void init() {
    }

    public String getModelUri() {
        return resource.getPath() + ".model.tidy.json";
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
