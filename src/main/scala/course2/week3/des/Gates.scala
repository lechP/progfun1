package course2.week3.des

abstract class Gates extends Simulation {

  def InverterDelay: Int

  def AndGateDelay: Int

  def OrGateDelay: Int

  class Wire {

    private var signalValue = false
    private var actions: List[Action] = List()

    def getSignal: Boolean = signalValue

    def setSignal(s: Boolean): Unit =
      if (s != signalValue) {
        signalValue = s
        actions foreach (_ ())
      }

    def addAction(a: Action): Unit = {
      actions = a :: actions
      a()
    }
  }

  def inverter(input: Wire, output: Wire): Unit = {
    def invertAction(): Unit = {
      val inputSig = input.getSignal
      afterDelay(InverterDelay) {
        output setSignal !inputSig
      }
    }
    input addAction invertAction
  }

  def andGate(in1: Wire, in2: Wire, output: Wire): Unit = {
    def andAction(): Unit = {
      val in1signal = in1.getSignal
      val in2signal = in2.getSignal
      afterDelay(AndGateDelay) {
        output setSignal in1signal & in2signal
      }
    }

    in1 addAction andAction
    in2 addAction andAction
  }

  def orGate(in1: Wire, in2: Wire, output: Wire): Unit = {
    def orAction(): Unit = {
      val in1signal = in1.getSignal
      val in2signal = in2.getSignal
      afterDelay(OrGateDelay) {
        output setSignal in1signal | in2signal
      }
    }

    in1 addAction orAction
    in2 addAction orAction
  }

  def probe(name: String, wire: Wire): Unit = {
    def probeAction(): Unit = {
      println(s"$name $currentTime value = ${wire.getSignal}")
    }
    wire addAction probeAction
  }


}


