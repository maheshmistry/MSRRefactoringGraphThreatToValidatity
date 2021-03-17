from modules import generator
from modules import graphproperties as prop
from modules import datasetconfig
from modules import util
import sys

def get_subgraphs_properties(lang='java'):

  langs={
        'java':datasetconfig.get_java_projects,
        'cpp':datasetconfig.get_cpp_projects,
        'js':datasetconfig.get_js_projects
        }
  lang_project = langs.get(lang,"Invalid Language")
  projects = lang_project()

  head = 'id;project;vertices;edges;age_days;developers;distinct_operations;commits'
  lines = []
  for project_name in projects:
    subgraphs = util.read_json('../../../../data/dataset/graphs/overtime_subgraphs_{}.json'.format(util.get_name_project_formated(project_name)))
    for subgraph in subgraphs:
      id = subgraph.get('id_intra_project')
      vertices = len(prop.get_vertices(subgraph))
      edges = len(prop.get_edges_id(subgraph))
      age_days = round(prop.get_age_in_days(subgraph))
      developers = len(prop.get_distinct_developers(subgraph))
      distinct_operations = len(prop.get_distinct_refactorings(subgraph))
      commits = len(prop.get_commits(subgraph))
      line = '{};{};{};{};{};{};{};{}'.format(id,project_name,vertices,edges,age_days,developers,distinct_operations,commits)
      lines.append(line)
  util.write_csv('../../../../data/dataset/{}_subgraphs_properties.csv'.format(lang), head, lines)
  pass

def graph_generator(option):
  options = {
    1: generator.find_disconnected_subgraphs,
    2: generator.create_views,
    3: get_subgraphs_properties
  }
  options[option]()
  return

def menu():
  print('1 - Generate subgraphs')
  print('2 - Generate views')
  print('3 - See subgraphs properties (size, age, number of distinct operations, etc)')


def run():
  option = 10
  while option != 0:
    menu()
    option = int(input('\nOption: '))
    graph_generator(option)
  return

#run()