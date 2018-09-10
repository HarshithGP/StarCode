import os, sys, time, robot, argparse, datetime
#from robot.api import ExecutionResult

def robot_call(suitename, dir, browser, robot_command):
    if not os.path.exists(os.path.join(dir, browser)):
        os.mkdir(os.path.join(dir, browser))

    dir = os.path.join(dir, browser)

    if not os.path.exists(os.path.join(dir, suitename)):
        os.mkdir(os.path.join(dir, suitename))

    dir = os.path.join(dir, suitename)

    timestamp = time.strftime('result-%m%d%y%H%M%S')
    if not os.path.exists(os.path.join(dir, timestamp)):
        os.mkdir(os.path.join(dir, timestamp))

    dir = os.path.join(dir, timestamp)

    output_dir = dir
    print     'python -m robot --outputdir %s -v BROWSER:%s %s' %(output_dir, browser, robot_command)
    os.system('python -m robot --outputdir %s -v BROWSER:%s %s' %(output_dir, browser, robot_command))
    if browser == 'chrome':
        os.system('pkill -f chromedriver')
        os.system('pkill -f /opt/google/chrome/chrome')
        os.system('pkill -f /opt/google/chrome/google-chrome')

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("-argument",type=str, required=True, help='Provide robot script details.')
    args = parser.parse_args()

    robot_command = args.argument
    today = datetime.date.today()
    todaystr = today.isoformat()

    parent = '/home/tester'

    if not os.path.exists(os.path.join(parent, 'robot_logs')):
        os.mkdir(os.path.join(parent, 'robot_logs'))

    cwd = os.path.join(parent, 'robot_logs')

    if not os.path.exists(os.path.join(cwd,todaystr)):
        os.mkdir(os.path.join(cwd, todaystr))

    cwd = os.path.join(cwd,todaystr)

    filename=robot_command.split('/')[-1]
    suitename=filename.split('.')[0]

    robot_call(suitename, cwd, 'chrome', robot_command)
    #robot_call(suitename, cwd, 'firefox', robot_command)
