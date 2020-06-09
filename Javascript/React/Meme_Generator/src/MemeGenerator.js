import React, { Component } from 'react';

class MemeGenerator extends Component {

    constructor(){
        super();
        this.state = {
            topText : "",
            bottomText : "",
            randomImage : "http://i.imgflip.com/1bij.jpg",
            allImages : []
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    componentDidMount(){
        fetch("https://api.imgflip.com/get_memes")
            .then(response=>response.json())
            .then(response=>{
                this.setState({allImages:response.data.memes})
            })
    }

    handleChange(event){
        let {name,value} = event.target
        this.setState({
            [name] : value
        })
    }

    handleSubmit(event){
        event.preventDefault();
        const randomNum = Math.floor( Math.random() * this.state.allImages.length);
        const randomImage = this.state.allImages[randomNum].url;
        this.setState({randomImage:randomImage})
    }

    render(){
        return (
            <div>
                <div className="meme">
                    <img src={this.state.randomImage} alt=""/>
                    <h2 className="top">{this.state.topText}</h2>
                    <h2 className="bottom">{this.state.bottomText}</h2>
                </div>
                <form className="meme-form" onSubmit={this.handleSubmit}>
                    <label>Enter a text to be at Top :</label>
                    <input className="textBox" type="text" name="topText" value={this.state.topText} onChange={this.handleChange} placeholder="Something" />
                    <br />
                    <label>Enter a text to be at Bottom :</label>
                    <input className="textBox" type="text" name="bottomText" value={this.state.bottomText} onChange={this.handleChange} placeholder="Something" />
                    <br />
                    <button className="button">Generate</button>
                </form>
            </div>
        );
    }

}

export default MemeGenerator;