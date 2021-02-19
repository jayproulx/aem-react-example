import React from 'react';
import ReactDOM from 'react-dom';

class MyAemReactComponent extends React.Component {
    render() {
        let title = this.props.title;
        let description = this.props.description;

        return <>
            <h1>{title}</h1>
            <p>{description}</p>
        </>;
    }
}

// todo: this should be run on content loaded, rather than right away at the end of the page
// todo: this worked in initial testing after editing the component, but needs further testing to ensure that if AEM updates the DOM, that the component
// todo: this initialization code should be run such that after the element is initialized, it will not be initialized again if this runs a second time
// todo: there's an opportunity to use the Sling Model Exporter to fetch data at load time

Array.prototype.slice.call(document.querySelectorAll('.my_aem_react_component')).map(function (element) {
    ReactDOM.render(
        <MyAemReactComponent
            title={element.dataset.title}
            description={element.dataset.description}
        />
        , element
    );
});