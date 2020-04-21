import flask

app = flask.Flask(__name__)

@app.route('/<number>', methods=['GET', 'POST'])
def oddOrEven(number):
    convertedNumber=int(number)
    if (convertedNumber%2==0):
        result="Bu bir çift sayıdır."
        pass
    else:
        result="Bu bir tek sayıdır."
        pass
    return "%s" % result

app.run(host="xxx.xxx.x.xx", port=5000, debug=True)