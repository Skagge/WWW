import './Scrolling.css';
import JSX_withParallax from '../parallax/ParallaxJSXWrapper';
import background from './back.png';

function Scrolling() {

    const FirstOrb = JSX_withParallax(<div style={styles.objOne}/>, 0.05);
    const SecondOrb = JSX_withParallax(<div style={styles.objTwo}/>, 0.02)
    const ThirdOrb = JSX_withParallax(<div style={styles.objThree}/>, 0.02)

    return (
        <div>
            <img className="custom-background" src={background} alt="alt"/>
            <FirstOrb />
            <SecondOrb />
            <ThirdOrb />
        </div>
    );
}

const styles = {
    objOne: {
        margin: 0,
        padding: 0,
        height: '200px',
        width: '200px',
        position: 'fixed',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        borderRadius: '50%',
        backgroundColor: '#0083FF',
        boxShadow: '0px 0px 20px 10px #0083FF'
    },

    objTwo: {
        margin: 0,
        padding: 0,
        height: '200px',
        width: '200px',
        position: 'fixed',
        top: '150%',
        left: '80%',
        transform: 'translate(-50%, -50%)',
        borderRadius: '50%',
        backgroundColor: 'red',
        boxShadow: '0px 0px 20px 10px #0083FF'
    },

    objThree: {
        margin: 0,
        padding: 0,
        height: '200px',
        width: '200px',
        position: 'fixed',
        top: '240%',
        left: '20%',
        transform: 'translate(-50%, -50%)',
        borderRadius: '50%',
        backgroundColor: 'green',
        boxShadow: '0px 0px 20px 10px #0083FF'
    }
}

export default Scrolling;