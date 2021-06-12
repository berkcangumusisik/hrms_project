import './App.css';
import Navi from './layouts/Navi';
import 'semantic-ui-css/semantic.min.css'
import { Container } from 'semantic-ui-react';
import DashBoard from './layouts/Dashboard';
import Footer from './layouts/Footer';
function App() {
  return (
  <div className="App">
      <Navi/>
      <Container className="main">
        <DashBoard/>
      </Container>

  </div>
  );
}

export default App;
