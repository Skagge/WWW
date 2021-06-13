import './App.css';
import Navbar from "../navbar/Navbar.js";
import Home from "../home/Home.js";
import Scrolling from "../scrolling/Scrolling.js";
import Photos from "../photos/Photos.js";
import { BrowserRouter as Router, Switch, Route} from "react-router-dom";

function App() {
  return (
      <Router>
          <div className="App">
              <Navbar/>
              <Switch>
                  <Route path="/" exact component={Home}/>
                  <Route path="/scrolling" component={Scrolling}/>
                  <Route path="/photos" component={Photos}/>
              </Switch>
          </div>
      </Router>
  );
}

export default App;
