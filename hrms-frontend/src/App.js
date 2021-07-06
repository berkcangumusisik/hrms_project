import './App.css';
import Navi from "./layouts/Navi";
import Dashboard from "./layouts/Dashboard";
import 'semantic-ui-css/semantic.min.css' 
import "@fortawesome/fontawesome-free/css/all.min.css";
import "./assets/styles/tailwind.css";
function App() {
  return (
    <div className="App">
      <Navi/>
      <Dashboard />
    </div>
  );
}

export default App;
