import React, { Component } from "react";
import axios from "axios";
import './Photos.css';

class Photos extends Component {

    constructor(props) {
        super(props);
        this.state = {
            photos: [],
            loading: false,
            page: 0,
            prevY: 0
        };
    }

    componentDidMount() {
        this.getPhotos(this.state.page);

        const options = {
            root: null,
            rootMargin: "0px",
            threshold: 1.0
        };

        this.observer = new IntersectionObserver(
            this.handleObserver.bind(this),
            options
        );
        this.observer.observe(this.loadingRef);
    }

    handleObserver(entities, observer) {
        const y = entities[0].boundingClientRect.y;
        if (this.state.prevY > y) {
            const lastPhoto = this.state.photos[this.state.photos.length - 1];
            const curPage = lastPhoto.albumId;
            this.getPhotos(curPage);
            this.setState({ page: curPage });
        }
        this.setState({ prevY: y });
    }

    render() {

        const loadingCSS = {
            height: "100px",
            margin: "30px"
        };

        const loadingTextCSS = { display: this.state.loading ? "block" : "none" };

        return (
            <div className="container">
                <div className="row">
                    <div className="col-12 text-center">
                        {this.state.photos.map(user => (
                            <img className="img-fluid custom-photos" src={user.url} alt="ERROR" key={ Math.random().toString(36).substr(2, 9)}/>
                        ))}
                    </div>
                    <div ref={loadingRef => (this.loadingRef = loadingRef)} style={loadingCSS}>
                            <span style={loadingTextCSS}>Loading...</span>
                    </div>
                </div>
            </div>
        );
    }

    getPhotos(page) {
        this.setState({ loading: true });
        axios
            .get(
                `https://jsonplaceholder.typicode.com/photos?_page=${page}&_limit=9`
            )
            .then(res => {
                this.setState({ photos: [...this.state.photos, ...res.data] });
                this.setState({ loading: false });
            });
    }
}

export default Photos;