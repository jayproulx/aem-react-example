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

Array.prototype.slice.call(document.querySelectorAll('.my_aem_react_component')).map(function(element) {
    ReactDOM.render(<MyAemReactComponent
    title={ element.dataset.title }
    description={ element.dataset.description }
        />, element);
});