import './Home.css';

function Home() {
    return (
      <div className="container custom-height">
          <div className="row">
              <div className="col text-end margins">
                  <div className="wrapper">
                      <span>S</span>
                      <span>I</span>
                      <span>N</span>
                      <span>G</span>
                      <span>L</span>
                      <span>E</span>
                  </div>
              </div>
              <div className="col text-center margins">
                  <div className="wrapper">
                      <span>P</span>
                      <span>A</span>
                      <span>G</span>
                      <span>E</span>
                  </div>
              </div>
              <div className="col text-start margins">
                  <div className="wrapper">
                      <span>A</span>
                      <span>P</span>
                      <span>P</span>
                  </div>
              </div>
          </div>
      </div>
    );
}

export default Home;